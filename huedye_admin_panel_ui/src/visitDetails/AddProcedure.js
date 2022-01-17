import { Box, Button, Modal, Typography } from '@mui/material';
import React from 'react';
import { useDispatch } from 'react-redux';
import { addProcedure } from '../reducers';
import ProcedureForm from './ProcedureForm';

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

  const AddProcedure = ({visitId}) => {
    const dispatch = useDispatch()
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    const submitProcedure = (values) => { 
      dispatch(addProcedure({ ...values}, visitId))
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
            <ProcedureForm form={"procedureForm"} onSubmit={submitProcedure} canEdit={true} cancel={handleClose}/>
          </Box>
        </Modal>
       </div>
       );
      
  }
 
export default AddProcedure;