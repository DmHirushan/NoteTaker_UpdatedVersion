package lk.ijse.gdse.aad68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad68.notetaker.dao.NoteDao;
import lk.ijse.gdse.aad68.notetaker.dto.NoteDTO;
import lk.ijse.gdse.aad68.notetaker.entity.NoteEntity;
import lk.ijse.gdse.aad68.notetaker.util.AppUtil;
import lk.ijse.gdse.aad68.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
@Transactional
public  class NoteServiceIMPL implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping mapping;

    @Override
    public String saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDTO);
        noteDao.save(noteEntity);
        return "Saved successfully in Service layer";
    }

    @Override
    public void updateNote(String noteId, NoteDTO incomeNoteDTO) {

    }

    @Override
    public boolean deleteNote(String noteId) {
        if (noteDao.existsById(noteId)){
            noteDao.deleteById(noteId);
            return true;
        }else {
            return false;
        }

    }

    @Override
    public NoteDTO getSelectedNote(String noteId) {
      return mapping.convertToDTO(noteDao.getReferenceById(noteId));
    }

    @Override
    public List<NoteDTO> getAllNotes() {
      return mapping.convertToDTO(noteDao.findAll());
    }
}
