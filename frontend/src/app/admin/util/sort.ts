export class Sort {

    private sortOrder = 1;
    private collator = new Intl.Collator(undefined, {
        numeric: true,
        sensitivity: 'base',
    });


    constructor() {
    }

    public startSort(property, order, type = '') {
        if (order === 'desc') {
            this.sortOrder = -1;
        }
        return (a, b) => {
            if (type === 'date') {
                return this.sortData(new Date(a[property]), new Date(b[property]));
            } else {
                return this.collator.compare(a[property], b[property]) * this.sortOrder;
            }
        };
    }
    private sortData(a, b) {
        if (a < b) {
            return -1 * this.sortOrder;
        } else if (a > b) {
            return 1 * this.sortOrder;
        } else {
            return 0 * this.sortOrder;
        }
    }


  public startSortWithTwoProperty(property, order, type = '') {
    const splitProperty = property.toString().split('.');
    if (order === 'desc') {
      this.sortOrder = -1;
    }
    return (a, b) => {
      if (type === 'date') {
        return this.sortData(new Date(a[splitProperty[0]][splitProperty[1]]), new Date(b[splitProperty[0]][splitProperty[1]]));
      } else {
        return this.collator.compare(a[splitProperty[0]][splitProperty[1]], b[splitProperty[0]][splitProperty[1]]) * this.sortOrder;
      }
    };
  }

  public startSortWithThreeProperty(property, order, type = '') {
    const splitProperty = property.toString().split('.');
    if (order === 'desc') {
      this.sortOrder = -1;
    }
    return (a, b) => {
      if (type === 'date') {
        // tslint:disable-next-line:max-line-length
        return this.sortData(new Date(a[splitProperty[0]][splitProperty[1]][splitProperty[2]]), new Date(b[splitProperty[0]][splitProperty[1]][splitProperty[2]]));
      } else {
        // tslint:disable-next-line:max-line-length
        return this.collator.compare(a[splitProperty[0]][splitProperty[1]][splitProperty[1]], b[splitProperty[0]][splitProperty[1]][splitProperty[2]]) * this.sortOrder;
      }
    };
  }
}
