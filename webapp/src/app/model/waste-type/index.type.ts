import { IBaseResponse } from "../base-response.type";

export interface IWasteTypeResponse extends IBaseResponse {
  data: Data;
}

interface Data {
  count: number;
  items: IWasteType[];
}

export interface IWasteType {
  id: number;
  name?: string;
  lastUpdatedAt?: string;
  createdAt?: string;
}