package mavenapp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Service
@Transactional
@RestController
public class StudControl {
	@Autowired
	StudRepo studRepo;
	@PostMapping("Studentsave")
	public String insertStudent(@RequestBody Student stud)
	{
		if(stud !=null) {
			studRepo.save(stud);
			return "Record has been saved";
		}
		return "Record has not been saved";
	}
	@PostMapping("multiStudentsave")
	public String insertStudent(@RequestBody List<Student> stud)
	{
		if(stud !=null) {
			studRepo.saveAll(stud);
			return "Records has been saved";
		}
		return "Record has not been saved";
	}
	@GetMapping("Byname/{name}")
	public List<Student> getStudent(@PathVariable("name") String studname){
	 return (List<Student>) studRepo.findBystudname(studname);	
	}
	@GetMapping("Byid/{studid}")
	public Student getStudent(@PathVariable("studid") Long studid){
	 return studRepo.findBystudid(studid);	
	}
	@GetMapping("Bybranch/{branch}")
	public List<Student> getStudent11(@PathVariable("branch") String studbranch){
	 return (List<Student>) studRepo.findBystudbranch(studbranch);	
	}
	@GetMapping("Bysem/{sem}")
	public List<Student> getStudent1(@PathVariable("sem") String studsem){
	 return (List<Student>) studRepo.findBystudsem(studsem);	
	}
	@GetMapping("Studentsinfo")
	public List<Student> getStudent(){
	 return (List<Student>) studRepo.findAll();	
	}
	@PutMapping("/Update/{id}")
	public String update(@PathVariable("id") Long studid, @RequestBody Student stud)  {
		 try {
		        Student existStudent = studRepo.findBystudid(studid);
		        existStudent.setStudname(stud.getStudname());
		        existStudent.setStudbranch(stud.getStudbranch());
		        existStudent.setStudsem(stud.getStudsem());
		        return "updated";
		    } catch (Exception e) {
		        return "Id Not found";
		    }      
		}
	@DeleteMapping("/Delete/{id}")
	public void delete(@PathVariable Long id) {
	    studRepo.deleteById(id);
	}
	@DeleteMapping("DeleteAll")
	public void delete() {
	    studRepo.deleteAll();
	}
	    	/*if(studRepo.existsById(studid) && stud !=null){
		        studRepo.save(stud);
		        return new ResponseEntity<>(HttpStatus.OK);
	    	}
	    	else
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);*/   
}
