package  ma.zs.stocky.ws.facade.admin.mandat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.stocky.bean.core.mandat.Mandat;
import ma.zs.stocky.dao.criteria.core.mandat.MandatCriteria;
import ma.zs.stocky.service.facade.admin.mandat.MandatAdminService;
import ma.zs.stocky.ws.converter.mandat.MandatConverter;
import ma.zs.stocky.ws.dto.mandat.MandatDto;
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
@RequestMapping("/api/admin/mandat/")
public class MandatRestAdmin  extends AbstractController<Mandat, MandatDto, MandatCriteria, MandatAdminService, MandatConverter> {



    @Operation(summary = "upload one mandat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple mandats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all mandats")
    @GetMapping("")
    public ResponseEntity<List<MandatDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  mandat")
    @PostMapping("")
    public ResponseEntity<MandatDto> save(@RequestBody MandatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  mandat")
    @PutMapping("")
    public ResponseEntity<MandatDto> update(@RequestBody MandatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of mandat")
    @PostMapping("multiple")
    public ResponseEntity<List<MandatDto>> delete(@RequestBody List<MandatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified mandat")
    @DeleteMapping("")
    public ResponseEntity<MandatDto> delete(@RequestBody MandatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified mandat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple mandats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by employe id")
    @GetMapping("employe/id/{id}")
    public List<MandatDto> findByEmployeId(@PathVariable Long id){
        return findDtos(service.findByEmployeId(id));
    }
    @Operation(summary = "delete by employe id")
    @DeleteMapping("employe/id/{id}")
    public int deleteByEmployeId(@PathVariable Long id){
        return service.deleteByEmployeId(id);
    }
    @Operation(summary = "find by responsabilite id")
    @GetMapping("responsabilite/id/{id}")
    public List<MandatDto> findByResponsabiliteId(@PathVariable Long id){
        return findDtos(service.findByResponsabiliteId(id));
    }
    @Operation(summary = "delete by responsabilite id")
    @DeleteMapping("responsabilite/id/{id}")
    public int deleteByResponsabiliteId(@PathVariable Long id){
        return service.deleteByResponsabiliteId(id);
    }
    @Operation(summary = "find by entiteAdmin id")
    @GetMapping("entiteAdmin/id/{id}")
    public List<MandatDto> findByEntiteAdminId(@PathVariable Long id){
        return findDtos(service.findByEntiteAdminId(id));
    }
    @Operation(summary = "delete by entiteAdmin id")
    @DeleteMapping("entiteAdmin/id/{id}")
    public int deleteByEntiteAdminId(@PathVariable Long id){
        return service.deleteByEntiteAdminId(id);
    }

    @Operation(summary = "Finds a mandat and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MandatDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds mandats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MandatDto>> findByCriteria(@RequestBody MandatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated mandats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MandatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports mandats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MandatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets mandat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MandatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public MandatRestAdmin (MandatAdminService service, MandatConverter converter) {
        super(service, converter);
    }




}
