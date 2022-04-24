import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { DataService } from '../data.service';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.sass']
})
export class EditorComponent implements OnInit {

  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Enter text here...',
    translate: 'no',
    defaultParagraphSeparator: 'p',
    defaultFontName: 'Arial',
    toolbarHiddenButtons: [
      ['bold']
    ],
    customClasses: [
      {
        name: "quote",
        class: "quote",
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: "titleText",
        class: "titleText",
        tag: "h1",
      },
    ]
  };

  formGroup: FormGroup = new FormGroup({
    title: new FormControl({ disabled: false, value: '' }, [Validators.required]),
    subTitle: new FormControl({ disabled: false, value: '' }, [Validators.required]),
    createDate: new FormControl({ disabled: false, value: new Date }, [Validators.required]),
    modifyDate: new FormControl({ disabled: false, value: new Date }, [Validators.required]),
    publishDate: new FormControl({ disabled: false, value: new Date }, [Validators.required]),
    html: new FormControl({ disabled: false, value: '' }, [Validators.required])
  });

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
  }

  public save(): void {

    if (this.formGroup.valid) {
      this.dataService.saveContent(this.formGroup.value).subscribe();
    }

  }

}
