import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsapiService {
  apiurl="http://localhost:8080/findProduct?pid=1"

  constructor(private http: HttpClient) { }
  getProducts(){
    const products= this.http.get(this.apiurl);
    console.log("fromapiservice:"+products);
    return products;
  }
}
