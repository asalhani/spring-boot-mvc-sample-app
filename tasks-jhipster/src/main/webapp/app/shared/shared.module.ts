import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TasksSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [TasksSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [TasksSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TasksSharedModule {
  static forRoot() {
    return {
      ngModule: TasksSharedModule
    };
  }
}
