package  ma.zs.stocky.ws.facade.admin.livraison;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.livraison.Livraison;
import ma.zs.stocky.dao.criteria.core.livraison.LivraisonCriteria;
import ma.zs.stocky.service.facade.admin.livraison.LivraisonAdminService;
import ma.zs.stocky.ws.converter.livraison.LivraisonConverter;
import ma.zs.stocky.ws.dto.livraison.LivraisonDto;
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
@RequestMapping("/api/admin/livraison/")
public class LivraisonRestAdmin  extends AbstractController<Livraison, LivraisonDto, LivraisonCriteria, LivraisonAdminService, LivraisonConverter> {



    @Operation(summary = "upload one livraison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple livraisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all livraisons")
    @GetMapping("")
    public ResponseEntity<List<LivraisonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all livraisons")
    @GetMapping("optimized")
    public ResponseEntity<List<LivraisonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a livraison by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<LivraisonDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Livraison(ref));
    }

    @Operation(summary = "Saves the specified  livraison")
    @PostMapping("")
    public ResponseEntity<LivraisonDto> save(@RequestBody LivraisonDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  livraison")
    @PutMapping("")
    public ResponseEntity<LivraisonDto> update(@RequestBody LivraisonDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of livraison")
    @PostMapping("multiple")
    public ResponseEntity<List<LivraisonDto>> delete(@RequestBody List<LivraisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified livraison")
    @DeleteMapping("")
    public ResponseEntity<LivraisonDto> delete(@RequestBody LivraisonDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified livraison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple livraisons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by reception id")
    @GetMapping("reception/id/{id}")
    public List<LivraisonDto> findByReceptionId(@PathVariable Long id){
        return findDtos(service.findByReceptionId(id));
    }
    @Operation(summary = "delete by reception id")
    @DeleteMapping("reception/id/{id}")
    public int deleteByReceptionId(@PathVariable Long id){
        return service.deleteByReceptionId(id);
    }

    @Operation(summary = "Finds a livraison and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LivraisonDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds livraisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LivraisonDto>> findByCriteria(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated livraisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports livraisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets livraison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LivraisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public LivraisonRestAdmin (LivraisonAdminService service, LivraisonConverter converter) {
        super(service, converter);
    }




}
