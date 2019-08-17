import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import { filter, map } from 'rxjs/operators';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { LoginModalService, AccountService, Account } from 'app/core';
import { PostService } from 'app/entities/post';
import { IPost } from 'app/shared/model/post.model';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
  account: Account;
  modalRef: NgbModalRef;
  posts: IPost[];

  constructor(
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private eventManager: JhiEventManager,
    protected postService: PostService,
    protected jhiAlertService: JhiAlertService
  ) {}

  ngOnInit() {
    this.loadAllPosts();
    this.accountService.identity().then((account: Account) => {
      this.account = account;
    });
    this.registerAuthenticationSuccess();
  }

  loadAllPosts() {
    this.postService
      .query()
      .pipe(
        filter((res: HttpResponse<IPost[]>) => res.ok),
        map((res: HttpResponse<IPost[]>) => res.body)
      )
      .subscribe(
        (res: IPost[]) => {
          this.posts = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  registerAuthenticationSuccess() {
    this.eventManager.subscribe('authenticationSuccess', message => {
      this.accountService.identity().then(account => {
        this.account = account;
      });
    });
  }

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }

  login() {
    this.modalRef = this.loginModalService.open();
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
