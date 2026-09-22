import { Component, signal } from '@angular/core';
import { QuickLink } from '../../components/quick-link/quick-link';

@Component({
  selector: 'app-materials',
  imports: [QuickLink],
  templateUrl: './materials.html',
  styleUrl: './materials.css',
})
export class Materials {
  listMaterials = signal(["Boulons", "Pièces détachées", "Huile moteur"])
}
