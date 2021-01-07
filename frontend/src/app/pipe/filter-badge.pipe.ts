import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterBadge'
})
export class FilterBadgePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    const splitProperty = value.toString().split('.');
    return splitProperty[1];
  }

}
