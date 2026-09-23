import { Component, inject } from '@angular/core';
import { AlimentItem } from '../../components/aliment-item/aliment-item';
import { QuickLink } from '../../components/quick-link/quick-link';
import { AlimentService } from '../../services/aliment-service';
import { ProductService } from '../../services/product-service';
import { Aliment } from '../../types/Aliment';

@Component({
  selector: 'app-aliments',
  imports: [QuickLink, AlimentItem],
  templateUrl: './aliments.html',
  styleUrl: './aliments.css',
})
export class Aliments {
  alimentService = inject(AlimentService);
  productService = inject(ProductService)

  alimentsList = this.productService.getProduct<Aliment>('http://127.0.0.1:3000/api/food/');
}
