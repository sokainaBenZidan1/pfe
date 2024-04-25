package  ma.zs.stocky.ws.facade.admin.budget;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.budget.BudgetCompteBudgetaire;
import ma.zs.stocky.dao.criteria.core.budget.BudgetCompteBudgetaireCriteria;
import ma.zs.stocky.service.facade.admin.budget.BudgetCompteBudgetaireAdminService;
import ma.zs.stocky.ws.converter.budget.BudgetCompteBudgetaireConverter;
import ma.zs.stocky.ws.dto.budget.BudgetCompteBudgetaireDto;
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
@RequestMapping("/api/admin/budgetCompteBudgetaire/")
public class BudgetCompteBudgetaireRestAdmin  extends AbstractController<BudgetCompteBudgetaire, BudgetCompteBudgetaireDto, BudgetCompteBudgetaireCriteria, BudgetCompteBudgetaireAdminService, BudgetCompteBudgetaireConverter> {



    @Operation(summary = "upload one budgetCompteBudgetaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple budgetCompteBudgetaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all budgetCompteBudgetaires")
    @GetMapping("")
    public ResponseEntity<List<BudgetCompteBudgetaireDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  budgetCompteBudgetaire")
    @PostMapping("")
    public ResponseEntity<BudgetCompteBudgetaireDto> save(@RequestBody BudgetCompteBudgetaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  budgetCompteBudgetaire")
    @PutMapping("")
    public ResponseEntity<BudgetCompteBudgetaireDto> update(@RequestBody BudgetCompteBudgetaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of budgetCompteBudgetaire")
    @PostMapping("multiple")
    public ResponseEntity<List<BudgetCompteBudgetaireDto>> delete(@RequestBody List<BudgetCompteBudgetaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified budgetCompteBudgetaire")
    @DeleteMapping("")
    public ResponseEntity<BudgetCompteBudgetaireDto> delete(@RequestBody BudgetCompteBudgetaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified budgetCompteBudgetaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple budgetCompteBudgetaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by budget id")
    @GetMapping("budget/id/{id}")
    public List<BudgetCompteBudgetaireDto> findByBudgetId(@PathVariable Long id){
        return findDtos(service.findByBudgetId(id));
    }
    @Operation(summary = "delete by budget id")
    @DeleteMapping("budget/id/{id}")
    public int deleteByBudgetId(@PathVariable Long id){
        return service.deleteByBudgetId(id);
    }
    @Operation(summary = "find by compteBudgetaire id")
    @GetMapping("compteBudgetaire/id/{id}")
    public List<BudgetCompteBudgetaireDto> findByCompteBudgetaireId(@PathVariable Long id){
        return findDtos(service.findByCompteBudgetaireId(id));
    }
    @Operation(summary = "delete by compteBudgetaire id")
    @DeleteMapping("compteBudgetaire/id/{id}")
    public int deleteByCompteBudgetaireId(@PathVariable Long id){
        return service.deleteByCompteBudgetaireId(id);
    }

    @Operation(summary = "Finds a budgetCompteBudgetaire and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BudgetCompteBudgetaireDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds budgetCompteBudgetaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BudgetCompteBudgetaireDto>> findByCriteria(@RequestBody BudgetCompteBudgetaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated budgetCompteBudgetaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BudgetCompteBudgetaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports budgetCompteBudgetaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BudgetCompteBudgetaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets budgetCompteBudgetaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BudgetCompteBudgetaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public BudgetCompteBudgetaireRestAdmin (BudgetCompteBudgetaireAdminService service, BudgetCompteBudgetaireConverter converter) {
        super(service, converter);
    }




}
