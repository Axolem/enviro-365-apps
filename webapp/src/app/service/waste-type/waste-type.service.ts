import type { IWasteTypeResponse } from '#/app/model/waste-type/index.type';
import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WasteTypeService {
  http = inject(HttpClient)

  baseUrl = "http://localhost:8080/api/v1/waste-type/"

  getWasteTypes(){
    return this.http.get<IWasteTypeResponse>(this.baseUrl);
  }


  constructor() { }
}
