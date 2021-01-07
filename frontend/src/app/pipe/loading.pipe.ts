import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'loading'
})
export class LoadingPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    if (value) {
      return value;
    } else { return 'Loading...' }
  }

}
