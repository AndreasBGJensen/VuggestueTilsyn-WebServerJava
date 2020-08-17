import React from 'react'
import Footer from "../Footer/Footer";
import FormUserDetail from "../Header/FormUserDetail";
import GridApp from "../../BackgroungGrid";
import Grid from "@material-ui/core/Grid";
import makeStyles from "@material-ui/core/styles/makeStyles";
import ContentTable from "../ContentTable";
import TestCollapseTable from "../TestCollapseTable";



const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        alignItems: 'center',
        textAlign: 'center',
    },
    leftNRightGrid: {
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,

    },
    centerGrid: {
        padding: theme.spacing(2),
        color: theme.palette.text.secondary,
    }
}));

function WelcomePage() {
    const classes = useStyles();
        return(
            <div>


                        <FormUserDetail/>

                    <Grid container className={classes.root}>
                        <Grid item className={classes.leftNRightGrid} xs={2}>
                            <h2  >sdfsdfsdf</h2>
                        </Grid>
                        <Grid item xs={8} className={classes.centerGrid}>
                            <ContentTable/>
                        </Grid>
                        <Grid item xs={8} className={classes.centerGrid}>
                            <TestCollapseTable/>
                        </Grid>
                        <Grid item className={classes.leftNRightGrid} xs={2}>
                            <h2>sdfsdfsdf</h2>
                        </Grid>
                    </Grid>

                        <Footer/>


            </div>
        )

}

export default WelcomePage;