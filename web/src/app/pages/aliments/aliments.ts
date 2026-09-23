import { Component, inject } from '@angular/core';
import { QuickLink } from '../../components/quick-link/quick-link';
import { AlimentService } from '../../services/aliment-service';
import { AlimentItem } from '../../components/aliment-item/aliment-item';

@Component({
  selector: 'app-aliments',
  imports: [QuickLink, AlimentItem],
  templateUrl: './aliments.html',
  styleUrl: './aliments.css',
})
export class Aliments {
  alimentService = inject(AlimentService);

  alimentsList = this.alimentService.getAliments();
}
