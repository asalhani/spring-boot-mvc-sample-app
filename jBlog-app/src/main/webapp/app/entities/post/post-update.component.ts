import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IPost, Post } from 'app/shared/model/post.model';
import { PostService } from './post.service';

@Component({
  selector: 'jhi-post-update',
  templateUrl: './post-update.component.html'
})
export class PostUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    title: [null, [Validators.required]],
    body: [null, [Validators.required]],
    author: [null, [Validators.required]]
  });

  constructor(protected postService: PostService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ post }) => {
      this.updateForm(post);
    });
  }

  updateForm(post: IPost) {
    this.editForm.patchValue({
      id: post.id,
      title: post.title,
      body: post.body,
      author: post.author
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const post = this.createFromForm();
    if (post.id !== undefined) {
      this.subscribeToSaveResponse(this.postService.update(post));
    } else {
      this.subscribeToSaveResponse(this.postService.create(post));
    }
  }

  private createFromForm(): IPost {
    return {
      ...new Post(),
      id: this.editForm.get(['id']).value,
      title: this.editForm.get(['title']).value,
      body: this.editForm.get(['body']).value,
      author: this.editForm.get(['author']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPost>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
