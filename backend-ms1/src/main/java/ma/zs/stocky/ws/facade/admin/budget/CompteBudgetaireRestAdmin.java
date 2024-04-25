package  ma.zs.stocky.ws.facade.admin.budget;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.budget.CompteBudgetaire;
import ma.zs.stocky.dao.criteria.core.budget.CompteBudgetaireCriteria;
import ma.zs.stocky.service.facade.admin.budget.CompteBudgetaireAdminService;
import ma.zs.stocky.ws.converter.budget.CompteBudgetaireConverter;
import ma.zs.stocky.ws.dto.budget.CompteBudgetaireDto;
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
@RequestMapping("/api/admin/compteBudgetaire/")
public class CompteBudgetaireRestAdmin  extends AbstractController<CompteBudgetaire, CompteBudgetaireDto, CompteBudgetaireCriteria, CompteBudgetaireAdminService, CompteBudgetaireConverter> {



    @Operation(summary = "upload one compteBudgetaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple compteBudgetaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all compteBudgetaires")
    @GetMapping("")
    public ResponseEntity<List<CompteBudgetaireDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all compteBudgetaires")
    @GetMapping("optimized")
    public ResponseEntity<List<CompteBudgetaireDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a compteBudgetaire by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CompteBudgetaireDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new CompteBudgetaire(libelle));
    }

    @Operation(summary = "Saves the specified  compteBudgetaire")
    @PostMapping("")
    public ResponseEntity<CompteBudgetaireDto> save(@RequestBody CompteBudgetaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  compteBudgetaire")
    @PutMapping("")
    public ResponseEntity<CompteBudgetaireDto> update(@RequestBody CompteBudgetaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of compteBudgetaire")
    @PostMapping("multiple")
    public ResponseEntity<List<CompteBudgetaireDto>> delete(@RequestBody List<CompteBudgetaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified compteBudgetaire")
    @DeleteMapping("")
    public ResponseEntity<CompteBudgetaireDto> delete(@RequestBody CompteBudgetaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified compteBudgetaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple compteBudgetaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a compteBudgetaire and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CompteBudgetaireDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds compteBudgetaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CompteBudgetaireDto>> findByCriteria(@RequestBody CompteBudgetaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated compteBudgetaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CompteBudgetaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports compteBudgetaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CompteBudgetaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets compteBudgetaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CompteBudgetaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CompteBudgetaireRestAdmin (CompteBudgetaireAdminService service, CompteBudgetaireConverter converter) {
        super(service, converter);
    }




}
