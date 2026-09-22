import { Component, signal } from '@angular/core';
import { QuickLink } from '../../components/quick-link/quick-link';

@Component({
  selector: 'app-nourishment',
  imports: [QuickLink],
  templateUrl: './nourishment.html',
  styleUrl: './nourishment.css',
})
export class Nourishment {
  listAliments = signal(["Pomme", "Poire", "Pastèque"])
}
