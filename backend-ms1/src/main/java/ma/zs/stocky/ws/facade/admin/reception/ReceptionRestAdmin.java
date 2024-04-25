package  ma.zs.stocky.ws.facade.admin.reception;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.reception.Reception;
import ma.zs.stocky.dao.criteria.core.reception.ReceptionCriteria;
import ma.zs.stocky.service.facade.admin.reception.ReceptionAdminService;
import ma.zs.stocky.ws.converter.reception.ReceptionConverter;
import ma.zs.stocky.ws.dto.reception.ReceptionDto;
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
@RequestMapping("/api/admin/reception/")
public class ReceptionRestAdmin  extends AbstractController<Reception, ReceptionDto, ReceptionCriteria, ReceptionAdminService, ReceptionConverter> {



    @Operation(summary = "upload one reception")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple receptions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all receptions")
    @GetMapping("")
    public ResponseEntity<List<ReceptionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all receptions")
    @GetMapping("optimized")
    public ResponseEntity<List<ReceptionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reception by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<ReceptionDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Reception(ref));
    }

    @Operation(summary = "Saves the specified  reception")
    @PostMapping("")
    public ResponseEntity<ReceptionDto> save(@RequestBody ReceptionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reception")
    @PutMapping("")
    public ResponseEntity<ReceptionDto> update(@RequestBody ReceptionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reception")
    @PostMapping("multiple")
    public ResponseEntity<List<ReceptionDto>> delete(@RequestBody List<ReceptionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reception")
    @DeleteMapping("")
    public ResponseEntity<ReceptionDto> delete(@RequestBody ReceptionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reception")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple receptions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by commande id")
    @GetMapping("commande/id/{id}")
    public List<ReceptionDto> findByCommandeId(@PathVariable Long id){
        return findDtos(service.findByCommandeId(id));
    }
    @Operation(summary = "delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }

    @Operation(summary = "Finds a reception and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReceptionDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds receptions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReceptionDto>> findByCriteria(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated receptions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports receptions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reception data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReceptionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReceptionRestAdmin (ReceptionAdminService service, ReceptionConverter converter) {
        super(service, converter);
    }




}
