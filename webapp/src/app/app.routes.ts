import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: "",
        pathMatch: 'full',
        async loadComponent() {
            const m = await import("#/app/home/home.component");
            return m.HomeComponent;
        },
        title: "Home"
    },
    {
        path: "recycle-bins",
        async loadComponent() {
            const m = await import("#/app/recycle-bins/recycle-bins.component");
            return m.RecycleBinsComponent;
        },
        title: "Home"
    },
    {
        path: "pick-up",
        async loadComponent() {
            const m = await import("#/app/pick-up/pick-up.component");
            return m.PickUpComponent;
        },
        title: "Home"
    }
];
