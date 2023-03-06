<?php

namespace App\Controller;

use App\Entity\Article;
use App\Form\ArticleType;
use App\Repository\ArticleRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ArticleController extends AbstractController
{
    /**
     * @Route("/articles", name="app_articles")
     */
    public function articles(ArticleRepository $articleRepo): Response
    {
        $articles = $articleRepo->findAll();

        return $this->render('article/index.html.twig', [
            "articles" => $articles,
        ]);
    }

    /**
     * @Route("/idarticle/{id<\d+>}", name="app_idarticle")
     */
    public function idArticle(int $id = 1, ArticleRepository $articleRepo): Response
    {
        $articles = $articleRepo->find($id);
        return $this->render('article/idarticle.html.twig', [
            'id' => $id,
            "article" => $articles,
        ]);
    }

    /**
     * @Route("/articleAdd", name="app_articleAdd")
     */
    public function articleAdd(Request $request, ManagerRegistry $doctrine): Response
    {
        $article = new Article();
        $form = $this->createForm(ArticleType::class, $article);

        $manager = $doctrine->getManager();

        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $article = $form->getData();
            $article->setDateCreation(new \DateTime());
            $manager->persist($article);
            $manager->flush(); //exécute les requêtes en base de donnée
        }

        return $this->renderForm('article/articleadd.html.twig', [
           'form' => $form,
        ]);
    }

     /**
     * @Route("/articleDelete/{id}", name="app_articleDelete")
     */
    public function categorieDelete(ManagerRegistry $doctrine, Article $article): Response
    {

            $manager = $doctrine->getManager();
            $manager->remove($article);
            $manager->flush();

            $this->addFlash(
                'sucess',
                'Votre article à été supprimé avec succès !'
            );

        return $this->redirectToRoute('app_articles');
    }
}
