import { IPickUp, IPickUpResponse } from '#/app/model/pick-up/index.type';
import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PickUpService {

  http = inject(HttpClient)

  baseUrl = "http://localhost:8080/api/v1/pick-up/"

  async postNewPickUp(data: Partial<IPickUp>) {

    const r = await fetch(this.baseUrl, {
      body: JSON.stringify(data), method: "POST", headers: {
        'Content-Type': 'application/json'
      },
    })

    return await r.json() as unknown as IPickUpResponse
  }

  getActivePickUps() {
    return this.http.get<IPickUpResponse>(this.baseUrl)
  }

  constructor() { }
}
