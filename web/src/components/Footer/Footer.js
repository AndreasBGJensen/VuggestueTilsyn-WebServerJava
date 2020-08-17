import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';
import Paper from "@material-ui/core/Paper";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        marginTop:30,
        backgroundColor: theme.palette.success.main,
        borderTop: 'solid 3px #999943',
    },
    subFooter: {
      backgroundColor: theme.palette.success.light,
        height:'10px',
    },
}));



function Footer(){

const classes = useStyles();

    return (
        <div className={classes.root}>
                <Grid container spacing={24}>
                    <Grid item xs={12} sm={3}>
                        <h1>fdsfsdf</h1>
                    </Grid>
                    <Grid item xs={12} sm={3}>
                        <h1>fdsfsdf</h1>
                    </Grid>
                    <Grid className={classes.subFooter}  item xs={12}>
                    </Grid>
                </Grid>

        </div>
    );
}

export default Footer;