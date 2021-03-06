import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SloService} from "../../../core/services/slo.service";
import {AlertService} from "../../../core/services/alert.service";
import {Uptime} from "../../../shared/models/uptime";
import {first} from "rxjs/operators";
import {AverageResponseTime} from "../../../shared/models/averageResponseTime";

@Component({
  selector: 'app-average-response-form',
  templateUrl: './average-response-form.component.html',
  styleUrls: ['./average-response-form.component.css']
})
export class AverageResponseFormComponent implements OnInit {

  sloForm: FormGroup;
  submitted = false;
  timeUnits = ['ms', 's', 'min', 'h', 'd'];

  @Input()
  currentSlaId: number;
  @Output()
  sloCreated = new EventEmitter();

  constructor(private formBuilder: FormBuilder) {
    this.sloForm = this.formBuilder.group({
      name: ['', Validators.required],
      averageResponseTimeValue: ['', Validators.required],
      timeUnit: ['', Validators.required]
    })
  }

  get f() {return this.sloForm.controls;}

  ngOnInit() {
  }

  onSubmit() {
    let slo = new AverageResponseTime();
    // slo = this.sloForm.value;
    slo.name = this.f.name.value;
    slo.sloType = 'Average Response Time';
    slo.slaId = this.currentSlaId;
    slo.averageResponseTime = this.f.averageResponseTimeValue.value;
    slo.timeUnit = this.f.timeUnit.value;
    this.sloCreated.emit(slo);
  }

}
