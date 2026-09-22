import { Component, input, signal } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-quick-link',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './quick-link.html',
  styleUrl: './quick-link.css',
})
export class QuickLink {
  path = input.required<string>()
  textLink = input.required<string>()
}
