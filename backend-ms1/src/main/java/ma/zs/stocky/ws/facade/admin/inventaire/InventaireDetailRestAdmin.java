package  ma.zs.stocky.ws.facade.admin.inventaire;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.inventaire.InventaireDetail;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireDetailCriteria;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireDetailAdminService;
import ma.zs.stocky.ws.converter.inventaire.InventaireDetailConverter;
import ma.zs.stocky.ws.dto.inventaire.InventaireDetailDto;
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
@RequestMapping("/api/admin/inventaireDetail/")
public class InventaireDetailRestAdmin  extends AbstractController<InventaireDetail, InventaireDetailDto, InventaireDetailCriteria, InventaireDetailAdminService, InventaireDetailConverter> {



    @Operation(summary = "upload one inventaireDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inventaireDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inventaireDetails")
    @GetMapping("")
    public ResponseEntity<List<InventaireDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  inventaireDetail")
    @PostMapping("")
    public ResponseEntity<InventaireDetailDto> save(@RequestBody InventaireDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inventaireDetail")
    @PutMapping("")
    public ResponseEntity<InventaireDetailDto> update(@RequestBody InventaireDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inventaireDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<InventaireDetailDto>> delete(@RequestBody List<InventaireDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inventaireDetail")
    @DeleteMapping("")
    public ResponseEntity<InventaireDetailDto> delete(@RequestBody InventaireDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inventaireDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inventaireDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<InventaireDetailDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by inventaire id")
    @GetMapping("inventaire/id/{id}")
    public List<InventaireDetailDto> findByInventaireId(@PathVariable Long id){
        return findDtos(service.findByInventaireId(id));
    }
    @Operation(summary = "delete by inventaire id")
    @DeleteMapping("inventaire/id/{id}")
    public int deleteByInventaireId(@PathVariable Long id){
        return service.deleteByInventaireId(id);
    }

    @Operation(summary = "Finds a inventaireDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InventaireDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds inventaireDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InventaireDetailDto>> findByCriteria(@RequestBody InventaireDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inventaireDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InventaireDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inventaireDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InventaireDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inventaireDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InventaireDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InventaireDetailRestAdmin (InventaireDetailAdminService service, InventaireDetailConverter converter) {
        super(service, converter);
    }




}
