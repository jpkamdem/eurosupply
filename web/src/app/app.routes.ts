import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    title: 'Accueil',
    loadComponent: () => import('./pages/home/home').then((mod) => mod.Home),
  },
  {
    path: 'aliments',
    title: 'Aliments',
    loadComponent: () =>
      import('./pages/aliments/aliments').then((mod) => mod.Aliments),
  },
  {
    path: 'materiels',
    title: 'Matériels',
    loadComponent: () =>
      import('./pages/materiels/materiels').then((mod) => mod.Materiels),
  },
  {
    path: '**',
    title: 'Erreur',
    loadComponent: () =>
      import('./pages/notfound/notfound').then((mod) => mod.Notfound),
  },
];
