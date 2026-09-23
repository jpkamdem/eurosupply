import type { Unit } from "./Unit";

export interface Medic {
  id: string;
  name: string;
  quantity: number;
  expiration: Date;
}