import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
            width: '25ch',
        },
    },
}));


function BasicTextFields(props) {
    const classes = useStyles();
console.log(props);

    return (
        <form className={classes.root} noValidate autoComplete="off" >
            <TextField id="outlined-basic" label="Søg institution" variant="outlined" onChange={(event) => props.onChange(event.target.value)} />
        </form>
    );
}

export default BasicTextFields;