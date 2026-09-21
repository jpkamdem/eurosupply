import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    title: 'Home',
    loadComponent: () => import('./pages/home/home').then((mod) => mod.Home),
  },
  {
    path: 'aliments',
    title: 'Aliments',
    loadComponent: () => import ('./pages/nourishment/nourishment').then((mod) => mod.Nourishment)
  },
  {
    path: 'materiels',
    title: 'Matériels',
    loadComponent: () => import ('./pages/materials/materials').then((mod) => mod.Materials)
  },
  {
    path: "**",
    title: 'Erreur',
    loadComponent: () => import ('./pages/notfound/notfound').then((mod) => mod.Notfound)
  }
];
