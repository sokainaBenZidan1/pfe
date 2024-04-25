package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.Stock;
import ma.zs.stocky.dao.criteria.core.stock.StockCriteria;
import ma.zs.stocky.service.facade.admin.stock.StockAdminService;
import ma.zs.stocky.ws.converter.stock.StockConverter;
import ma.zs.stocky.ws.dto.stock.StockDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/stock/")
public class StockRestAdmin  extends AbstractController<Stock, StockDto, StockCriteria, StockAdminService, StockConverter> {



    @Operation(summary = "upload one stock")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple stocks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all stocks")
    @GetMapping("")
    public ResponseEntity<List<StockDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  stock")
    @PostMapping("")
    public ResponseEntity<StockDto> save(@RequestBody StockDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  stock")
    @PutMapping("")
    public ResponseEntity<StockDto> update(@RequestBody StockDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of stock")
    @PostMapping("multiple")
    public ResponseEntity<List<StockDto>> delete(@RequestBody List<StockDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified stock")
    @DeleteMapping("")
    public ResponseEntity<StockDto> delete(@RequestBody StockDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified stock")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple stocks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by magasin id")
    @GetMapping("magasin/id/{id}")
    public List<StockDto> findByMagasinId(@PathVariable Long id){
        return findDtos(service.findByMagasinId(id));
    }
    @Operation(summary = "delete by magasin id")
    @DeleteMapping("magasin/id/{id}")
    public int deleteByMagasinId(@PathVariable Long id){
        return service.deleteByMagasinId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<StockDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }

    @Operation(summary = "Finds a stock and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StockDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds stocks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StockDto>> findByCriteria(@RequestBody StockCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated stocks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StockCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports stocks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StockCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets stock data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StockCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public StockRestAdmin (StockAdminService service, StockConverter converter) {
        super(service, converter);
    }




}
