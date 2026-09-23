import { Component, inject } from '@angular/core';
import { MaterielItem } from '../../components/materiel-item/materiel-item';
import { QuickLink } from '../../components/quick-link/quick-link';
import { ProductService } from '../../services/product-service';

@Component({
  selector: 'app-materiels',
  imports: [QuickLink, MaterielItem],
  providers: [ProductService],
  templateUrl: './materiels.html',
  styleUrl: './materiels.css',
})
export class Materiels {
    #productService = inject(ProductService);

    materielsList = this.#productService.getMateriels();
}
