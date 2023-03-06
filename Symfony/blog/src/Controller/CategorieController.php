<?php

namespace App\Controller;

use App\Entity\Categorie;
use App\Form\CategorieType;
use App\Repository\CategorieRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


class CategorieController extends AbstractController
{
    /**
     * @Route("/categories", name="app_categories")
     */
    public function Categories(CategorieRepository $categorieRepo): Response
    {
        $categories = $categorieRepo->findAll();

        return $this->render('categorie/index.html.twig', [
            "categories" => $categories,
        ]);
    }

    /**
     * @Route("/categorie/{id<\d+>}", name="app_idcategorie")
     */
    public function idCategorie($id = 1, CategorieRepository $categorieRepo): Response
    {
        $categorie = $categorieRepo->find($id);
        return $this->render('categorie/idcategorie.html.twig', [
            'categorie' => $categorie,
        ]);
    }

    /**
     * @Route("/categorieAdd", name="app_categorieAdd")
     */
    public function CategorieAdd(Request $request, ManagerRegistry $doctrine): Response
    {
        $categorie = new Categorie();
        $form = $this->createForm(CategorieType::class, $categorie);

        $manager = $doctrine->getManager();

        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $categorie = $form->getData();

            $manager->persist($categorie);
            $manager->flush(); //exécute les requêtes en base de donnée
        }

        return $this->renderForm('categorie/categorieadd.html.twig', [
            'form' => $form,
        ]);
    }

    /**
     * @Route("/categorieDelete/{id}", name="app_categorieDelete")
     */
    public function categorieDelete(ManagerRegistry $doctrine, Categorie $categorie): Response
    {

        if ($categorie->getArticles()->isEmpty()) {

            $manager = $doctrine->getManager();
            $manager->remove($categorie);
            $manager->flush();

            $this->addFlash(
                'sucess',
                'Votre Catégorie à été supprimé avec succès !'
            );
        } else {
            $this->addFlash(
                'error', 
                'La Catégorie ne peut pas être supprimé car elle possède des articles !'
            );
        }

        return $this->redirectToRoute('app_categories');
    }
}
