package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.OperationStock;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockCriteria;
import ma.zs.stocky.service.facade.admin.stock.OperationStockAdminService;
import ma.zs.stocky.ws.converter.stock.OperationStockConverter;
import ma.zs.stocky.ws.dto.stock.OperationStockDto;
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
@RequestMapping("/api/admin/operationStock/")
public class OperationStockRestAdmin  extends AbstractController<OperationStock, OperationStockDto, OperationStockCriteria, OperationStockAdminService, OperationStockConverter> {



    @Operation(summary = "upload one operationStock")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple operationStocks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all operationStocks")
    @GetMapping("")
    public ResponseEntity<List<OperationStockDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all operationStocks")
    @GetMapping("optimized")
    public ResponseEntity<List<OperationStockDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a operationStock by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<OperationStockDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new OperationStock(ref));
    }

    @Operation(summary = "Saves the specified  operationStock")
    @PostMapping("")
    public ResponseEntity<OperationStockDto> save(@RequestBody OperationStockDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  operationStock")
    @PutMapping("")
    public ResponseEntity<OperationStockDto> update(@RequestBody OperationStockDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of operationStock")
    @PostMapping("multiple")
    public ResponseEntity<List<OperationStockDto>> delete(@RequestBody List<OperationStockDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified operationStock")
    @DeleteMapping("")
    public ResponseEntity<OperationStockDto> delete(@RequestBody OperationStockDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified operationStock")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple operationStocks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by magasinSource id")
    @GetMapping("magasinSource/id/{id}")
    public List<OperationStockDto> findByMagasinSourceId(@PathVariable Long id){
        return findDtos(service.findByMagasinSourceId(id));
    }
    @Operation(summary = "delete by magasinSource id")
    @DeleteMapping("magasinSource/id/{id}")
    public int deleteByMagasinSourceId(@PathVariable Long id){
        return service.deleteByMagasinSourceId(id);
    }
    @Operation(summary = "find by magasinDest id")
    @GetMapping("magasinDest/id/{id}")
    public List<OperationStockDto> findByMagasinDestId(@PathVariable Long id){
        return findDtos(service.findByMagasinDestId(id));
    }
    @Operation(summary = "delete by magasinDest id")
    @DeleteMapping("magasinDest/id/{id}")
    public int deleteByMagasinDestId(@PathVariable Long id){
        return service.deleteByMagasinDestId(id);
    }

    @Operation(summary = "Finds a operationStock and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OperationStockDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds operationStocks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OperationStockDto>> findByCriteria(@RequestBody OperationStockCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated operationStocks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OperationStockCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports operationStocks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OperationStockCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets operationStock data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OperationStockCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public OperationStockRestAdmin (OperationStockAdminService service, OperationStockConverter converter) {
        super(service, converter);
    }




}
