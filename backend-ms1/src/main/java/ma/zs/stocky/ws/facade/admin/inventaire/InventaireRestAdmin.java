package  ma.zs.stocky.ws.facade.admin.inventaire;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.inventaire.Inventaire;
import ma.zs.stocky.dao.criteria.core.inventaire.InventaireCriteria;
import ma.zs.stocky.service.facade.admin.inventaire.InventaireAdminService;
import ma.zs.stocky.ws.converter.inventaire.InventaireConverter;
import ma.zs.stocky.ws.dto.inventaire.InventaireDto;
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
@RequestMapping("/api/admin/inventaire/")
public class InventaireRestAdmin  extends AbstractController<Inventaire, InventaireDto, InventaireCriteria, InventaireAdminService, InventaireConverter> {



    @Operation(summary = "upload one inventaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inventaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inventaires")
    @GetMapping("")
    public ResponseEntity<List<InventaireDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  inventaire")
    @PostMapping("")
    public ResponseEntity<InventaireDto> save(@RequestBody InventaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inventaire")
    @PutMapping("")
    public ResponseEntity<InventaireDto> update(@RequestBody InventaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inventaire")
    @PostMapping("multiple")
    public ResponseEntity<List<InventaireDto>> delete(@RequestBody List<InventaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inventaire")
    @DeleteMapping("")
    public ResponseEntity<InventaireDto> delete(@RequestBody InventaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inventaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inventaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by responsableInv id")
    @GetMapping("responsableInv/id/{id}")
    public List<InventaireDto> findByResponsableInvId(@PathVariable Long id){
        return findDtos(service.findByResponsableInvId(id));
    }
    @Operation(summary = "delete by responsableInv id")
    @DeleteMapping("responsableInv/id/{id}")
    public int deleteByResponsableInvId(@PathVariable Long id){
        return service.deleteByResponsableInvId(id);
    }

    @Operation(summary = "Finds a inventaire and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InventaireDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds inventaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InventaireDto>> findByCriteria(@RequestBody InventaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inventaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InventaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inventaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InventaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inventaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InventaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InventaireRestAdmin (InventaireAdminService service, InventaireConverter converter) {
        super(service, converter);
    }




}
