import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {OperationStockDto} from './OperationStock.model';
import {ProduitDto} from '../produit/Produit.model';

export class OperationStockDetailDto extends BaseDto{

    public qte: null | number;

    public produit: ProduitDto ;
    public operationStock: OperationStockDto ;
    

    constructor() {
        super();

        this.qte = null;
        this.produit = new ProduitDto() ;
        this.operationStock = new OperationStockDto() ;

        }

}
