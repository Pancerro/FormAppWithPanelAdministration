import {Voivodeship} from '../enumPack/voivodeship.enum';
import {Area} from '../enumPack/area.enum';

export interface ContactDetails {
  idContact?: number;
  street?: string;
  houseNumber?: string;
  township?: string;
  postOffice?: string;
  postalCode?: string;
  community?: string;
  district?: string;
  voivodeship?: Voivodeship;
  area?: Area;
  phoneNumber?: string;
  email?: string;
}
