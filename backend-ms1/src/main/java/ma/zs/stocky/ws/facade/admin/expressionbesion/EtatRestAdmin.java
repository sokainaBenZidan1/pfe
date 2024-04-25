package  ma.zs.stocky.ws.facade.admin.expressionbesion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.expressionbesion.Etat;
import ma.zs.stocky.dao.criteria.core.expressionbesion.EtatCriteria;
import ma.zs.stocky.service.facade.admin.expressionbesion.EtatAdminService;
import ma.zs.stocky.ws.converter.expressionbesion.EtatConverter;
import ma.zs.stocky.ws.dto.expressionbesion.EtatDto;
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
@RequestMapping("/api/admin/etat/")
public class EtatRestAdmin  extends AbstractController<Etat, EtatDto, EtatCriteria, EtatAdminService, EtatConverter> {



    @Operation(summary = "upload one etat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etats")
    @GetMapping("")
    public ResponseEntity<List<EtatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etat by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Etat(libelle));
    }

    @Operation(summary = "Saves the specified  etat")
    @PostMapping("")
    public ResponseEntity<EtatDto> save(@RequestBody EtatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etat")
    @PutMapping("")
    public ResponseEntity<EtatDto> update(@RequestBody EtatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatDto>> delete(@RequestBody List<EtatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etat")
    @DeleteMapping("")
    public ResponseEntity<EtatDto> delete(@RequestBody EtatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a etat and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatDto>> findByCriteria(@RequestBody EtatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatRestAdmin (EtatAdminService service, EtatConverter converter) {
        super(service, converter);
    }




}
