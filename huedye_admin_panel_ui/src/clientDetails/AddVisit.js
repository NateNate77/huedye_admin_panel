import { Box, Button, Modal, Typography } from '@mui/material';
import React from 'react';
import { useDispatch } from 'react-redux';
import { addVisit } from '../reducers';
import AddVisitForm from './AddVisitForm';


const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };

  const AddVisit = () => {
    const dispatch = useDispatch()
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const submitVisit = (values) => { // id визита добавить
      dispatch(addVisit({ ...values}))
      handleClose();
    }
    
    return(<div>
        <Button onClick={handleOpen} variant="contained">Добавить</Button>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <AddVisitForm onSubmit={submitVisit}/>
          </Box>
        </Modal>
       </div>
       );
      
  }
 
export default AddVisit;