import { Component, inject } from '@angular/core';
import { HlmSelectImports } from '../components/ui/ui-select-helm/src';
import { HlmButtonDirective } from '../components/ui/ui-button-helm/src';
import { HlmInputDirective } from '../components/ui/ui-input-helm/src';
import { HlmLabelDirective } from '../components/ui/ui-label-helm/src';
import { BrnSelectImports } from '@spartan-ng/brain/select';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HlmCalendarComponent } from '../components/ui/ui-calendar-helm/src';
import { WasteTypeService } from '../service/waste-type/waste-type.service';
import { rxResource } from "@angular/core/rxjs-interop"
import { PickUpService } from '../service/pick-up/pick-up.service';
import { HlmToasterComponent } from '../components/ui/ui-sonner-helm/src';
import { toast } from 'ngx-sonner';

@Component({
  selector: 'app-pick-up',
  imports: [BrnSelectImports, HlmSelectImports, HlmToasterComponent,HlmLabelDirective, HlmCalendarComponent, HlmInputDirective, HlmButtonDirective, ReactiveFormsModule],
  templateUrl: './pick-up.component.html',
  styles: ``
})
export class PickUpComponent {

  wasteTypeService = inject(WasteTypeService)
  pickUpService = inject(PickUpService)

  wasteTypes = rxResource({
    loader: () => {
      return this.wasteTypeService.getWasteTypes()
    }
  })

  pickUps = rxResource({
    loader: () => {
      return this.pickUpService.getActivePickUps()
    }
  })


  minDate = new Date(Date.now() + 1000 * 60 * 60 * 24);
  maxDate = new Date(Date.now() + 1000 * 60 * 60 * 24 * 7);

  newPickUpForm = new FormGroup({
    wasteType: new FormControl<number | null>(null, [Validators.required]),
    pickupDate: new FormControl<Date | null>(null, [Validators.required]),
    pickupTime: new FormControl('', [Validators.required]),
  });

  typeOnChange(type: any) {
    if (typeof type !== "number") return;

    this.newPickUpForm.patchValue({
      wasteType: type
    })
  }

  dateChange(date: Date) {
    this.newPickUpForm.patchValue({
      pickupDate: date
    })
  }
  timeChange(time: any) {
    this.newPickUpForm.patchValue({
      pickupTime: time.value
    })
  }

async  onSubmit() {
   const res = await this.pickUpService.postNewPickUp(
      {
        date: this.newPickUpForm.value.pickupDate?.toISOString().split("T")[0],
        time: this.newPickUpForm.value.pickupTime!,
        wasteType: {
          id: this.newPickUpForm.value.wasteType!
        }
      }
    )

    this.pickUps.reload();

    toast(res.message, {
      description: res.details || undefined,
    })

  }
}
