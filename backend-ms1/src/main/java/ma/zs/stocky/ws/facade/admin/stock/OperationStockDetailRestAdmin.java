package  ma.zs.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.stock.OperationStockDetail;
import ma.zs.stocky.dao.criteria.core.stock.OperationStockDetailCriteria;
import ma.zs.stocky.service.facade.admin.stock.OperationStockDetailAdminService;
import ma.zs.stocky.ws.converter.stock.OperationStockDetailConverter;
import ma.zs.stocky.ws.dto.stock.OperationStockDetailDto;
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
@RequestMapping("/api/admin/operationStockDetail/")
public class OperationStockDetailRestAdmin  extends AbstractController<OperationStockDetail, OperationStockDetailDto, OperationStockDetailCriteria, OperationStockDetailAdminService, OperationStockDetailConverter> {



    @Operation(summary = "upload one operationStockDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple operationStockDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all operationStockDetails")
    @GetMapping("")
    public ResponseEntity<List<OperationStockDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  operationStockDetail")
    @PostMapping("")
    public ResponseEntity<OperationStockDetailDto> save(@RequestBody OperationStockDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  operationStockDetail")
    @PutMapping("")
    public ResponseEntity<OperationStockDetailDto> update(@RequestBody OperationStockDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of operationStockDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<OperationStockDetailDto>> delete(@RequestBody List<OperationStockDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified operationStockDetail")
    @DeleteMapping("")
    public ResponseEntity<OperationStockDetailDto> delete(@RequestBody OperationStockDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified operationStockDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple operationStockDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<OperationStockDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by operationStock id")
    @GetMapping("operationStock/id/{id}")
    public List<OperationStockDetailDto> findByOperationStockId(@PathVariable Long id){
        return findDtos(service.findByOperationStockId(id));
    }
    @Operation(summary = "delete by operationStock id")
    @DeleteMapping("operationStock/id/{id}")
    public int deleteByOperationStockId(@PathVariable Long id){
        return service.deleteByOperationStockId(id);
    }

    @Operation(summary = "Finds a operationStockDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OperationStockDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds operationStockDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OperationStockDetailDto>> findByCriteria(@RequestBody OperationStockDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated operationStockDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OperationStockDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports operationStockDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OperationStockDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets operationStockDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OperationStockDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public OperationStockDetailRestAdmin (OperationStockDetailAdminService service, OperationStockDetailConverter converter) {
        super(service, converter);
    }




}
