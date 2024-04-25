import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {MagasinDto} from './Magasin.model';
import {OperationStockDto} from './OperationStock.model';
import {OperationStockDetailDto} from './OperationStockDetail.model';
import {ProduitDto} from '../produit/Produit.model';

export class OperationStockDto extends BaseDto{

    public ref: string;

   public dateOS: Date;

    public discription: string;

    public magasinSource: MagasinDto ;
    public magasinDest: MagasinDto ;
     public operationStockDetails: Array<OperationStockDetailDto>;
    

    constructor() {
        super();

        this.ref = '';
        this.dateOS = null;
        this.discription = '';
        this.magasinSource = new MagasinDto() ;
        this.magasinDest = new MagasinDto() ;
        this.operationStockDetails = new Array<OperationStockDetailDto>();

        }

}
