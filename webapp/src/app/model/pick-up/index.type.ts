import type { IBaseResponse } from "../base-response.type";
import type { IWasteType } from "../waste-type/index.type";

export interface IPickUpResponse extends IBaseResponse {
    data: Data;
}

interface Data {
    count: number;
    items: IPickUp[];
}

export interface IPickUp {
    id: number;
    date: string;
    time: string;
    wasteType: IWasteType;
    lastUpdatedAt: string;
    createdAt: string;
}

