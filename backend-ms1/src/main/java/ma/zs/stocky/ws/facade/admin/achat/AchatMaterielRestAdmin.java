package  ma.zs.stocky.ws.facade.admin.achat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.achat.AchatMateriel;
import ma.zs.stocky.dao.criteria.core.achat.AchatMaterielCriteria;
import ma.zs.stocky.service.facade.admin.achat.AchatMaterielAdminService;
import ma.zs.stocky.ws.converter.achat.AchatMaterielConverter;
import ma.zs.stocky.ws.dto.achat.AchatMaterielDto;
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
@RequestMapping("/api/admin/achatMateriel/")
public class AchatMaterielRestAdmin  extends AbstractController<AchatMateriel, AchatMaterielDto, AchatMaterielCriteria, AchatMaterielAdminService, AchatMaterielConverter> {



    @Operation(summary = "upload one achatMateriel")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple achatMateriels")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all achatMateriels")
    @GetMapping("")
    public ResponseEntity<List<AchatMaterielDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  achatMateriel")
    @PostMapping("")
    public ResponseEntity<AchatMaterielDto> save(@RequestBody AchatMaterielDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  achatMateriel")
    @PutMapping("")
    public ResponseEntity<AchatMaterielDto> update(@RequestBody AchatMaterielDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of achatMateriel")
    @PostMapping("multiple")
    public ResponseEntity<List<AchatMaterielDto>> delete(@RequestBody List<AchatMaterielDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified achatMateriel")
    @DeleteMapping("")
    public ResponseEntity<AchatMaterielDto> delete(@RequestBody AchatMaterielDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified achatMateriel")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple achatMateriels by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by budget id")
    @GetMapping("budget/id/{id}")
    public List<AchatMaterielDto> findByBudgetId(@PathVariable Long id){
        return findDtos(service.findByBudgetId(id));
    }
    @Operation(summary = "delete by budget id")
    @DeleteMapping("budget/id/{id}")
    public int deleteByBudgetId(@PathVariable Long id){
        return service.deleteByBudgetId(id);
    }
    @Operation(summary = "find by typeAchatMateriel id")
    @GetMapping("typeAchatMateriel/id/{id}")
    public List<AchatMaterielDto> findByTypeAchatMaterielId(@PathVariable Long id){
        return findDtos(service.findByTypeAchatMaterielId(id));
    }
    @Operation(summary = "delete by typeAchatMateriel id")
    @DeleteMapping("typeAchatMateriel/id/{id}")
    public int deleteByTypeAchatMaterielId(@PathVariable Long id){
        return service.deleteByTypeAchatMaterielId(id);
    }

    @Operation(summary = "Finds a achatMateriel and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatMaterielDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds achatMateriels by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AchatMaterielDto>> findByCriteria(@RequestBody AchatMaterielCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated achatMateriels by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AchatMaterielCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports achatMateriels by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AchatMaterielCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets achatMateriel data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AchatMaterielCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AchatMaterielRestAdmin (AchatMaterielAdminService service, AchatMaterielConverter converter) {
        super(service, converter);
    }




}
