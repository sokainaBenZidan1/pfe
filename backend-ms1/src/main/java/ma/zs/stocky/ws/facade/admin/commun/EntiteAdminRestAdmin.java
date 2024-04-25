package  ma.zs.stocky.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.commun.EntiteAdmin;
import ma.zs.stocky.dao.criteria.core.commun.EntiteAdminCriteria;
import ma.zs.stocky.service.facade.admin.commun.EntiteAdminAdminService;
import ma.zs.stocky.ws.converter.commun.EntiteAdminConverter;
import ma.zs.stocky.ws.dto.commun.EntiteAdminDto;
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
@RequestMapping("/api/admin/entiteAdmin/")
public class EntiteAdminRestAdmin  extends AbstractController<EntiteAdmin, EntiteAdminDto, EntiteAdminCriteria, EntiteAdminAdminService, EntiteAdminConverter> {



    @Operation(summary = "upload one entiteAdmin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple entiteAdmins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all entiteAdmins")
    @GetMapping("")
    public ResponseEntity<List<EntiteAdminDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all entiteAdmins")
    @GetMapping("optimized")
    public ResponseEntity<List<EntiteAdminDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a entiteAdmin by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EntiteAdminDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EntiteAdmin(libelle));
    }

    @Operation(summary = "Saves the specified  entiteAdmin")
    @PostMapping("")
    public ResponseEntity<EntiteAdminDto> save(@RequestBody EntiteAdminDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  entiteAdmin")
    @PutMapping("")
    public ResponseEntity<EntiteAdminDto> update(@RequestBody EntiteAdminDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of entiteAdmin")
    @PostMapping("multiple")
    public ResponseEntity<List<EntiteAdminDto>> delete(@RequestBody List<EntiteAdminDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified entiteAdmin")
    @DeleteMapping("")
    public ResponseEntity<EntiteAdminDto> delete(@RequestBody EntiteAdminDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified entiteAdmin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple entiteAdmins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a entiteAdmin and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntiteAdminDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds entiteAdmins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntiteAdminDto>> findByCriteria(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated entiteAdmins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports entiteAdmins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets entiteAdmin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntiteAdminCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EntiteAdminRestAdmin (EntiteAdminAdminService service, EntiteAdminConverter converter) {
        super(service, converter);
    }




}
