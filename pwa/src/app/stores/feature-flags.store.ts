import { Injectable, OnDestroy } from "@angular/core";
import { BehaviorSubject, debounceTime, Subject } from "rxjs";
import { FeatureFlag } from "../model/feature-flag.model";
import { FeatureFlagsService } from "../services/feature-flags.service";
import { FeatureFlagEnum } from "../model/feature-flag.enum";

@Injectable({
  providedIn: "root" // one instance for the whole application
})
export class FeatureFlagsStore implements OnDestroy {

  private changeSubjects = new Map<number, Subject<FeatureFlag>>();
  private subject = new BehaviorSubject<FeatureFlag[]>([])
  featureFlags$ = this.subject.asObservable();

  constructor(
    private featureFlagService: FeatureFlagsService,
  ) {
  }
  isActive(feature : string) : boolean {
    return !!this.subject.getValue().find(item => item.feature === feature)?.flag;
  }

  isNavActive(): boolean {
    return this.isActive(FeatureFlagEnum.NAV);
  }

  save(featureFlag : FeatureFlag) {
    this.featureFlagService.put(featureFlag).subscribe();
    if (!this.changeSubjects.has(featureFlag.id)) {
      const subject = new Subject<FeatureFlag>();
      subject.pipe(
        debounceTime(1000)
      ).subscribe(latestItem => {
        this.featureFlagService.put(latestItem).subscribe();
      });
      this.changeSubjects.set(featureFlag.id, subject);
    }
    this.changeSubjects.get(featureFlag.id)!.next(featureFlag);
  }

  ngOnDestroy() {
    this.changeSubjects.forEach(subject => subject.unsubscribe());
  }
}






