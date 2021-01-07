import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'noData'
})
export class NoDataPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    if (value == null) { value = '-'; }
    if (value === '') { value = '-'; }
    if (value === false) { value = 'nie'; }
    if (value === true) { value = 'tak'; }
    if (value === undefined) { value = '-'; }
    return value;
  }

}
