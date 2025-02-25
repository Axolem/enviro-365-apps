import { Component, signal } from '@angular/core';
import { HlmSelectImports } from '../components/ui/ui-select-helm/src';
import { HlmButtonDirective } from '../components/ui/ui-button-helm/src';
import { HlmInputDirective } from '../components/ui/ui-input-helm/src';
import { HlmLabelDirective } from '../components/ui/ui-label-helm/src';
import { BrnSelectImports } from '@spartan-ng/brain/select';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HlmCalendarComponent } from '../components/ui/ui-calendar-helm/src';

@Component({
  selector: 'app-pick-up',
  imports: [BrnSelectImports, HlmSelectImports, HlmLabelDirective, HlmCalendarComponent, HlmInputDirective, HlmButtonDirective, ReactiveFormsModule],
  templateUrl: './pick-up.component.html',
  styles: ``
})
export class PickUpComponent {
  minDate = new Date(Date.now() + 1000 * 60 * 60 * 24)
  maxDate = new Date(Date.now() + 1000 * 60 * 60 * 24 * 7);

  newPickUpForm = new FormGroup({
    wasteType: new FormControl('', [Validators.required]),
    pickupDate: new FormControl<Date | null>(null, [Validators.required]),
    pickupTime: new FormControl('', [Validators.required]),
  });

  dateChange(date: Date) {
    this.newPickUpForm.patchValue({
      pickupDate: date
    })
  }
}
