package  ma.zs.stocky.ws.facade.admin.expressionbesion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.expressionbesion.ExpressionBesoinDetail;
import ma.zs.stocky.dao.criteria.core.expressionbesion.ExpressionBesoinDetailCriteria;
import ma.zs.stocky.service.facade.admin.expressionbesion.ExpressionBesoinDetailAdminService;
import ma.zs.stocky.ws.converter.expressionbesion.ExpressionBesoinDetailConverter;
import ma.zs.stocky.ws.dto.expressionbesion.ExpressionBesoinDetailDto;
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
@RequestMapping("/api/admin/expressionBesoinDetail/")
public class ExpressionBesoinDetailRestAdmin  extends AbstractController<ExpressionBesoinDetail, ExpressionBesoinDetailDto, ExpressionBesoinDetailCriteria, ExpressionBesoinDetailAdminService, ExpressionBesoinDetailConverter> {



    @Operation(summary = "upload one expressionBesoinDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple expressionBesoinDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all expressionBesoinDetails")
    @GetMapping("")
    public ResponseEntity<List<ExpressionBesoinDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  expressionBesoinDetail")
    @PostMapping("")
    public ResponseEntity<ExpressionBesoinDetailDto> save(@RequestBody ExpressionBesoinDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  expressionBesoinDetail")
    @PutMapping("")
    public ResponseEntity<ExpressionBesoinDetailDto> update(@RequestBody ExpressionBesoinDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of expressionBesoinDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<ExpressionBesoinDetailDto>> delete(@RequestBody List<ExpressionBesoinDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified expressionBesoinDetail")
    @DeleteMapping("")
    public ResponseEntity<ExpressionBesoinDetailDto> delete(@RequestBody ExpressionBesoinDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified expressionBesoinDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple expressionBesoinDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by expressionBesoin id")
    @GetMapping("expressionBesoin/id/{id}")
    public List<ExpressionBesoinDetailDto> findByExpressionBesoinId(@PathVariable Long id){
        return findDtos(service.findByExpressionBesoinId(id));
    }
    @Operation(summary = "delete by expressionBesoin id")
    @DeleteMapping("expressionBesoin/id/{id}")
    public int deleteByExpressionBesoinId(@PathVariable Long id){
        return service.deleteByExpressionBesoinId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<ExpressionBesoinDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }

    @Operation(summary = "Finds a expressionBesoinDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ExpressionBesoinDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds expressionBesoinDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ExpressionBesoinDetailDto>> findByCriteria(@RequestBody ExpressionBesoinDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated expressionBesoinDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ExpressionBesoinDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports expressionBesoinDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ExpressionBesoinDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets expressionBesoinDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ExpressionBesoinDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ExpressionBesoinDetailRestAdmin (ExpressionBesoinDetailAdminService service, ExpressionBesoinDetailConverter converter) {
        super(service, converter);
    }




}
